package com.example.jetpackdemo.data.remote.dto


import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("data")
    val `data`: Data?=null
) : BaseDTO(){
    data class Data(
        @SerializedName("country_code")
        val countryCode: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("licence_expiry_date")
        val licenceExpiryDate: String,
        @SerializedName("licence_number")
        val licenceNumber: String,
        @SerializedName("mobile_number")
        val mobileNumber: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("permissions")
        val permissions: JsonObject,
        @SerializedName("profile")
        val profile: String,
        @SerializedName("token")
        var token: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("vehicle")
        val vehicle: Vehicle
    ) {
        data class Permissions(
            @SerializedName("allow_bid")
            val allowBid: Int,
            @SerializedName("change_password")
            val changePassword: Int,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("my_loads")
            val myLoads: Int,
            @SerializedName("my_profile")
            val myProfile: Int,
            @SerializedName("post_availibility")
            val postAvailibility: Int,
            @SerializedName("search_loads")
            val searchLoads: Int,
            @SerializedName("settings")
            val settings: Int,
            @SerializedName("statistics")
            val statistics: Int,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("view_price")
            val viewPrice: Int
        )

        data class Vehicle(
            @SerializedName("brand")
            val brand: String,
            @SerializedName("brands")
            val brands: Brands,
            @SerializedName("capacity_pallets")
            val capacityPallets: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("fuel_type")
            val fuelType: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("id_proof")
            val idProof: String,
            @SerializedName("images")
            val images: List<String>,
            @SerializedName("license")
            val license: String,
            @SerializedName("load_capacity")
            val loadCapacity: String,
            @SerializedName("load_capacity_unit")
            val loadCapacityUnit: LoadCapacityUnit,
            @SerializedName("pallets")
            val pallets: Int,
            @SerializedName("registration_no")
            val registrationNo: String,
            @SerializedName("trailer_registration_no")
            val trailerRegistrationNo: String,
            @SerializedName("truck_capacity")
            val truckCapacity: String,
            @SerializedName("truck_capacity_unit")
            val truckCapacityUnit: String,
            @SerializedName("truck_features")
            val truckFeatures: List<TruckFeature>,
            @SerializedName("truck_sub_category")
            val truckSubCategory: TruckSubCategory,
            @SerializedName("truck_type")
            val truckType: TruckType,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("vehicle_capacity")
            val vehicleCapacity: ArrayList<VehicleCapacity>,
            @SerializedName("weight")
            val weight: String,
            @SerializedName("weight_unit")
            val weightUnit: WeightUnit
        ) {
            data class Brands(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String
            )

            data class LoadCapacityUnit(
                @SerializedName("id")
                val id: Int=0,
                @SerializedName("name")
                val name: String=""
            )

            data class TruckFeature(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String
            )

            data class TruckSubCategory(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String
            )

            data class TruckType(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String
            )

            data class VehicleCapacity(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("driver_vehicle_id")
                val driverVehicleId: Int,
                @SerializedName("id")
                val id: Int,
                @SerializedName("package_type_id")
                val packageTypeId: PackageTypeId,
                @SerializedName("updated_at")
                val updatedAt: String,
                @SerializedName("value")
                val value: String
            ) {
                data class PackageTypeId(
                    @SerializedName("id")
                    val id: Int,
                    @SerializedName("name")
                    val name: String
                )
            }

            data class WeightUnit(
                @SerializedName("id")
                val id: Int=0,
                @SerializedName("name")
                val name: String=""
            )
        }
    }
}