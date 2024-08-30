# Android_Api_Explorer

What is [mockapi.io](https://mockapi.io)?

mockapi.io is a simple tool that lets you easily mock up APIs, generate custom data, and perform operations on it using RESTful interface. It is meant to be used as a prototyping/testing/learning tool.

[Doku/Wiki](https://github.com/mockapi-io/docs/wiki)

Der `MockApiService` stellt zwei Endpunkte bereit: `@GET("restaurants") und @POST("make-reservation")`.

```KOTLIN
    @GET("restaurants")
    suspend fun getRestaurants() : List<Restaurant>

    @POST("make-reservation")
    suspend fun makeReservation(@Body request: ReservationRequest)
```

Der Post-Request `make-reservation` sendet im RequestBody das von mockapi.io erstellte Object 
```KOTLIN
data class ReservationRequest(
    val restaurantId: Int,
    val userEmail: String,
    val userPhone: String,
    val time: String,
    val date: String,
    val numberOfPeople: Int
)
```
Hier wird eine Reservierung für ein Restaurant gemocket.

![Screenshot 2024-08-30 at 11 25 16](https://github.com/user-attachments/assets/16cc6acc-6b6e-47d6-8ffe-c47dbc609dce)

![Screenshot 2024-08-30 at 11 24 41](https://github.com/user-attachments/assets/f11830ee-fe9d-4f36-b694-ad52bd6318f4)
