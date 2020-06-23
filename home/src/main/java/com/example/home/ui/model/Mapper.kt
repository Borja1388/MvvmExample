package com.example.home.ui.model

import com.example.common.models.FactBo

fun FactBo.toVo() = FactVo(text = this.text, type = this.type)