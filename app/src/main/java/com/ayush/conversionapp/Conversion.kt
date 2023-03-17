package com.ayush.conversionapp

class Conversion {
    fun kmToml(dbNumber: Double): Double {
        return dbNumber * 0.62137119
    }

    fun mlTOkm(dbNumber: Double): Double {
        return dbNumber * 1.61
    }

    fun cmToin(dbNumber: Double): Double {
        return dbNumber * 0.39
    }

    fun inTOcm(dbNumber: Double): Double {
        return dbNumber * 2.54
    }

    fun kgTopo(dbNumber: Double): Double {
        return dbNumber * 2.2
    }

    fun poTokg(dbNumber: Double): Double {
        return dbNumber * 0.45
    }

    fun grToou(dbNumber: Double): Double {
        return dbNumber * 0.04
    }

    fun ouTogr(dbNumber: Double): Double {
        return dbNumber * 28.35
    }

    fun ceTofa(dbNumber: Double): Double {
        return dbNumber * 9 / 5 + 32
    }

    fun ceToke(dbNumber: Double): Double {
        return dbNumber + 273.15
    }

    fun faToce(dbNumber: Double): Double {
        return (dbNumber - 32) * 5 / 9
    }

    fun keToce(dbNumber: Double): Double {
        return (dbNumber - 32) * 5 / 9 + 273.15
    }

    fun ltTocu(dbNumber: Double): Double {
        return dbNumber * 4.17
    }

    fun cuTolt(dbNumber: Double): Double {
        return dbNumber * 0.24
    }
}