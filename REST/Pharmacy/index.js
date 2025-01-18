const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");
require("dotenv").config();

const pharmacyRoutes = require("./routes/pharmacyRoutes");

const app = express();

// Middleware
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// db connection
const mongoDb = "mongodb://localhost:27017/HospitalDB";
mongoose.connect(mongoDb, {});
const db = mongoose.connection;
db.on("open", () => {
    console.log("Connected to MongoDB");
});
db.on("error", console.error.bind(console, "mongo connection error"));

// Routes
app.use("/pharmacy", pharmacyRoutes);

// Start Server
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server is running on port ${PORT}`));
