using MongoDB.Bson;
using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace PatientService
{
    public class PatientService : IPatientService
    {
        private readonly IMongoCollection<Patient> _patients;

        public PatientService()
        {
            var client = new MongoClient("mongodb://localhost:27017");
            var database = client.GetDatabase("HospitalDB");
            _patients = database.GetCollection<Patient>("patients");
        }

        public Patient AddPatient(string cin, string firstName, string lastName, string email, string phone, string address)
        {
            var existingPatient = _patients.Find(p => p.cin == cin).FirstOrDefault();

            if (existingPatient != null)
            {
                Console.WriteLine("A patient with this CIN already exists.");
                return existingPatient;
            }

            Patient patient = new Patient
            {
                cin = cin,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
                address = address
            };
            _patients.InsertOne(patient);
            Console.WriteLine("Patient added successfully.");

            return patient;
        }


        public Patient GetPatientByCin(string cin)
        {
            return _patients.Find(p => p.cin == cin).FirstOrDefault();
        }

        public List<Patient> GetAllPatients()
        {
            return _patients.Find(p => true).ToList();
        }

        public void UpdatePatient(string cin, string firstName, string lastName, string email, string phone, string address)
        {
            var filter = Builders<Patient>.Filter.Eq(p => p.cin, cin);
            var update = Builders<Patient>.Update
                .Set(p => p.firstName, firstName)
                .Set(p => p.lastName, lastName)
                .Set(p => p.email, email)
                .Set(p => p.phone, phone)
                .Set(p => p.address, address);

            _patients.UpdateOne(filter, update);
        }

        public void DeletePatient(string cin)
        {
            var filter = Builders<Patient>.Filter.Eq(p => p.cin, cin);
            _patients.DeleteOne(filter);
        }

        //private static List<Patient> patients = new List<Patient>();
        //public void AddPatient(Patient patient)
        //{
        //    var pat = new Patient { Cin = "14521667", FirstName = "Asma", LastName = "Khelifi", Address = "Soukra", Email = "718.asma.khelifi@gmail.com", Phone = "94173087" };
        //    patients.Add(patient);
        //}

        //public List<Patient> GetAllPatients()
        //{
        //    return patients;
        //}

        //public Patient GetPatientByCin(string cin)
        //{
        //    return patients.Find(p => p.Cin == cin);
        //}
    }
}
