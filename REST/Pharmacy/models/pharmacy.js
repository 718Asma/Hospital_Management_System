const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const pharmacySchema = new Schema({
    code: {
        type: String,
        required: true,
    },
    name: {
        type: String,
        required: true,
    },
    address: {
        type: String,
        required: true,
    },
    phone: {
        type: String,
        required: true,
    },
});

// Export model
module.exports = mongoose.model("Pharmacy", pharmacySchema);