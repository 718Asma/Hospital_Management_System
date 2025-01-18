const express = require("express");
const router = express.Router();
const pharmacyController = require("../controllers/pharmacyController");


router.post("/add", pharmacyController.addPharmacy);
router.get("/all", pharmacyController.getAllPharmacies);
router.get("/id/:id", pharmacyController.getPharmacyById);
router.get("/code/:code", pharmacyController.getPharmacyByCode);
router.delete("/delete/:code", pharmacyController.deletePharmacy);
router.put("/update/:code", pharmacyController.updatePharmacy);

module.exports = router;