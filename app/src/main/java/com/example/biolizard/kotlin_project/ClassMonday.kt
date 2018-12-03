package com.example.biolizard.kotlin_project


// Si queremos heredar de una clase en kotlin hay que poner open
// el constructor se hace en la declaracion de la clase
// val es una constante, var una variable
// si una variable puede ser null se le pone ?

// Una extension
fun String.isEqualUTAD() = this.equals("UTAD", ignoreCase = true)

fun Int.isPoorStudent() = this < 18_000

object ClassMondaySingleton {
    
}

open class ClassMonday(val name: String = "david", val surname: String? = null) {
    //constructor( user: String) : this(user,null)

    companion object {
        val KEY_DEFAULT_NAME = "KEY_DEFAULT_NAME"
        fun getKeyDefault() = KEY_DEFAULT_NAME
    }

    private var completeName = "$name ${surname ?: ""}"
    private val jobs = listOf("trabajo1", "trabajo2", null)
    private var salary: Int? = null

    init {
        //completeName = "$name ${surname ?: ""}"
        salary = 45_000
    }

    //cmd j crear funciones
    // funcion que devuelve un String
    fun userName() = completeName

    private fun manageJobs(): Pair<Int, String?> {
        jobs.forEach { it ->

        }
        // map al final devuelve todo el listado
        val jobsNotEmpty = jobs.map { it ->
            it ?: ""
            if (it.isNullOrBlank()) "" else it
        }
        val jobsNotNull = jobs.first { !it.isNullOrBlank() }
        val job3 = jobs.first { (it?.length ?: 0) > 3 }

        val countJobs = jobsNotEmpty.count { (it?.length ?: 0) > 3 }
        return Pair(countJobs, job3)
    }

    private fun jobsData() {
        // trabajamos dentro del contexto del objeto
        val withResponse = with(manageJobs()) {
            print(first)
            print(second)
            true
        }
        val runResponse = manageJobs().run {
            print(first)
            print(second)
            true
        }
        val applyResponse: Pair<Int, String?> = manageJobs().apply {
            print(first)
            print(second)

        }
        val alsoResponse: Pair<Int, String?> = manageJobs().also {
            print(it.first)
            print(it.second)
        }
    }

    private fun dataParser() {
        "Alumnos".capitalize()
        "David".isEqualUTAD()

        salary?.isPoorStudent()

        // devuelve dentro el valor que no va a ser null
        salary?.let {
            it.isPoorStudent()
        } ?: kotlin.run {
            salary = 42_000
        }

        val jobsFiltered = jobs.filter { !it.isNullOrBlank() }

        val isPoor: Any = when (salary) {

            in 0..10_000 -> {
                true
            }
            in 10_001..16_000 -> {
                true
            }
            in 16_001..32_000 -> {
                true
            }
            else -> {
                false
            }


        }
        when (isPoor) {
            String -> {

            }
            Int -> {

            }
            null -> {

            }
            else -> {

            }
        }

    }


}