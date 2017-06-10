package br.com.pdt.leroapp.kt

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as When

class Lero {

    @Test
    fun lero_shouldNotLero() {
        val mockedLero: Mockee = mock(Mockee::class.java)
        When(mockedLero.lero()).thenReturn("mockedLero")
        assertEquals("mockedLero", mockedLero.lero())
    }

    @Test
    fun lero_shouldLero() {
        val mockedLero: Mockee = mock(Mockee::class.java)
        When(mockedLero.lero()).thenCallRealMethod()
        assertEquals("leroAsString", mockedLero.lero())
    }

}

open class Mockee {

    open fun lero(): String = "leroAsString".apply { println("lero") }

}