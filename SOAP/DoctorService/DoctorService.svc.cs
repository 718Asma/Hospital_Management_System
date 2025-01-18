using MongoDB.Bson;
using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace DoctorService
{
    public class DoctorService : IDoctorService
    {
        private readonly IMongoCollection<Doctor> _doctors;

        public DoctorService()
        {
            var client = new MongoClient("mongodb://localhost:27017");
            var database = client.GetDatabase("HospitalDB");
            _doctors = database.GetCollection<Doctor>("doctors");
        }

        public Doctor AddDoctor(string cin, string firstName, string lastName, string email, string phone, string address)
        {
            var existingDoctor = _doctors.Find(d => d.cin == cin).FirstOrDefault();

            if (existingDoctor != null)
            {
                Console.WriteLine("A doctor with this CIN already exists.");
                return existingDoctor;
            }

            Doctor doctor = new Doctor
            {
                cin = cin,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
                address = address
            };
            _doctors.InsertOne(doctor);
            Console.WriteLine("Doctor added successfully.");

            return doctor;
        }


        public Doctor GetDoctorByCin(string cin)
        {
            return _doctors.Find(d => d.cin == cin).FirstOrDefault();
        }

        public List<Doctor> GetAllDoctors()
        {
            return _doctors.Find(d => true).ToList();
        }

        public void UpdateDoctor(string cin, string firstName, string lastName, string email, string phone, string address)
        {
            var filter = Builders<Doctor>.Filter.Eq(d => d.cin, cin);
            var update = Builders<Doctor>.Update
                .Set(d => d.firstName, firstName)
                .Set(d => d.lastName, lastName)
                .Set(d => d.email, email)
                .Set(d => d.phone, phone)
                .Set(d => d.address, address);

            _doctors.UpdateOne(filter, update);
        }

        public void DeleteDoctor(string cin)
        {
            var filter = Builders<Doctor>.Filter.Eq(d => d.cin, cin);
            _doctors.DeleteOne(filter);
        }
    }
}
