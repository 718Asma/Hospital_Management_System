using MongoDB.Bson;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace DoctorService
{
    [ServiceContract]
    public interface IDoctorService
    {
        [OperationContract]
        Doctor AddDoctor(string cin, string firstName, string lastName, string email, string phone, string address);

        [OperationContract]
        Doctor GetDoctorByCin(string cin);

        [OperationContract]
        List<Doctor> GetAllDoctors();

        [OperationContract]
        void UpdateDoctor(string cin, string firstName, string lastName, string email, string phone, string address);

        [OperationContract]
        void DeleteDoctor(string cin);
    }
}
