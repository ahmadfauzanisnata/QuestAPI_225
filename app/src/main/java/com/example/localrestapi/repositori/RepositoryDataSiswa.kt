package com.example.localrestapi.repositori

import com.example.localrestapi.apiservice.ServiceApiSiswa
import com.example.localrestapi.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void>

}

class JaringanRepositoryDataSiswa(
    private val ServiceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{

override suspend fun getDataSiswa(): List<DataSiswa> = ServiceApiSiswa.getSiswa()
override suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = ServiceApiSiswa.postSiswa(dataSiswa)
}