const Pharmacy = require("../models/pharmacy");

exports.addPharmacy = async (req, res) => {
    try {
        const { code } = req.body;

        const existingPharmacy = await Pharmacy.findOne({ code });

        if (existingPharmacy) {
            return res.status(200).json({
                success: true,
                message: 'Pharmacy already exists.',
                data: { id: existingPharmacy._id }
            });
        }

        const pharmacy = new Pharmacy(req.body);
        await pharmacy.save();

        res.status(201).json({
            success: true,
            message: 'Pharmacy added successfully.',
            data: pharmacy
        });
    } catch (error) {
        res.status(400).json({
            success: false,
            error: error.message
        });
    }
};

exports.getAllPharmacies = async (req, res) => {
    try {
        const pharmacies = await Pharmacy.find();
        res.status(200).json(pharmacies);
    } catch (error) {
        res.status(500).json({ success: false, error: error.message });
    }
};

exports.getPharmacyById = async (req, res) => {
    try {
        const { id } = req.params;

        const pharmacy = await Pharmacy.findById(id);

        if (!pharmacy) {
            return res.status(404).json({ success: false, message: "Pharmacy not found" });
        }

        return res.status(200).json({ success: true, data: pharmacy });
    } catch (error) {
        return res.status(500).json({ success: false, error: error.message });
    }
};

exports.getPharmacyByCode = async (req, res) => {
    try {
        const pharmacy = await Pharmacy.findOne({ code: req.params.code });
        if (!pharmacy) {
            return res.status(404).json({ success: false, message: "Pharmacy not found" });
        }
        return res.status(200).json(pharmacy);
    } catch (error) {
        return res.status(500).json({ success: false, error: error.message });
    }
};

exports.deletePharmacy = async (req, res) => {
    try {
        const pharmacy = await Pharmacy.findOneAndDelete({ code: req.params.code });
        if (!pharmacy) {
            return res.status(404).json({ success: false, message: "Pharmacy not found" });
        }
        return res.status(200).json({ success: true, message: "Pharmacy deleted successfully", data: pharmacy });
    } catch (error) {
        return res.status(500).json({ success: false, error: error.message });
    }
};

exports.updatePharmacy = async (req, res) => {
    try {
        const pharmacy = await Pharmacy.findOneAndUpdate(
            { code: req.params.code },
            req.body,
            { new: true } // Return the updated document
        );
        if (!pharmacy) {
            return res.status(404).json({ success: false, message: "Pharmacy not found" });
        }
        return res.status(200).json({ success: true, message: "Pharmacy updated successfully", data: pharmacy });
    } catch (error) {
        return res.status(500).json({ success: false, error: error.message });
    }
};
