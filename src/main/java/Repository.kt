// https://codelabs.developers.google.com/codelabs/java-to-kotlin#0

// In Kotlin, the primary constructor cannot contain any code, so initialization code is placed in init blocks

// Kotlin supports Object Destructuring

// Elvis Operator

// keeping the constructor private to enforce the usage of getInstance

// The !! operator converts any variable to a non-null type, so you can access properties or call functions on it

// prefer val over var immutable

// Kotlin provides an extensive list of collection transformations

// that make development faster and safer by expanding the capabilities of the Java Collections API

// an object instead represents a single static instance, and can never have any more or any less than this one instance.

// 11. Scope functions: let, apply, with, run, also

// https://medium.com/androiddevelopers/kotlin-standard-functions-cheat-sheet-27f032dd4326

val User.formattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "Unknown"
            }
        } else {
            firstName ?: "Unknown"
        }
    }

object Repository {

    private val _users = mutableListOf<User>()

    val users: List<User> get() = _users
    val formattedUserNames: List<String> get() = _users.map { user -> user.formattedName } //  if oneliner

    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        _users.apply {
            // this == _users
            this.add(user1)
            this.add(user2)
            this.add(user3)
        }

    }
}
