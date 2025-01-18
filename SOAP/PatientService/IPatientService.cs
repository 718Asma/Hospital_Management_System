using MongoDB.Bson;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace PatientService
{
    [ServiceContract]
    public interface IPatientService
    {
        [OperationContract]
        Patient AddPatient(string cin, string firstName, string lastName, string email, string phone, string address);

        [OperationContract]
        Patient GetPatientByCin(string cin);

        [OperationContract]
        List<Patient> GetAllPatients();

        [OperationContract]
        void UpdatePatient(string cin, string firstName, string lastName, string email, string phone, string address);

        [OperationContract]
        void DeletePatient(string cin);
    }
}