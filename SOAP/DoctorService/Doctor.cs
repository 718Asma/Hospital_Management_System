using MongoDB.Bson.Serialization.Attributes;
using MongoDB.Bson;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace DoctorService
{
    public class Doctor
    {
        [BsonId]
        public ObjectId Id { get; set; }

        [DataMember]
        public string cin { get; set; }

        [DataMember]
        public string firstName { get; set; }

        [DataMember]
        public string lastName { get; set; }

        [DataMember]
        public string address { get; set; }

        [DataMember]
        public string email { get; set; }

        [DataMember]
        public string phone { get; set; }
    }
}