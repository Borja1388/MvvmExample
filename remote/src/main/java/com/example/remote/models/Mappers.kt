package com.example.remote.models

import com.example.common.models.FactBo

//Version corta ahorra codigo y se
fun FactDto.toBo(): FactBo = FactBo(text = text, type = type)

//version larga con return
/*fun FactDto.toBo2(): FactBo {
    return FactBo(text = text, type = type)
}*/

//Version antigua para hacer funciones
//fun factDtoToBo(factDto: FactDto): FactBo = FactBo(text = factDto.text, type = factDto.type)

//version antigua para hacer funciones con return
/*fun factDtoToBo2(factDto: FactDto): FactBo {
    return FactBo(text = factDto.text, type = factDto.type)
}*/