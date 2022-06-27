
**Sistema de turnos**

**Testing**

## **Versión 1.0**

Tabla de contenido

[**Datos del Sistema**	]

[**Datos de Entrada**	]

[**Datos de Salida esperado**	]

[**Datos de Salida obtenidos**	]

[**Comentarios**	]

# **Funcionalidad a testear: Reagendar turno**
#
# **Datos del Sistema**

- **Secretarias:**
1. s1(nombre: Josefa, apellido: Martínez, usuario: Josefa Martínez, dirección: Alsina 200, teléfono: 202020, DNI: 35012456, email: josefa@gmail.com)
1. s2(nombre: Lorena, apellido: Martínez, usuario: Lorena Martínez, dirección: San Martin 200, teléfono: 2020, DNI: 12012456, email: <lorena@gmail.com>)

- **Cuentas:**
1. (contraseña: 1, secretaria: s1);
1. (contraseña: 2, secretaria: s2);

- **Médicos:**
1. m1 (matricula:1, nombre: Lucas, apellido: Quiroga, dirección: Colombia 622, teléfono: 123456, DNI: 38178273, quiroga@gmail.com, 11, 17);
1. m2 (matricula: 2, nombre: Alfredo, apellido: Macri, dirección: Garibaldi 1050, teléfono:654321, 30123456, alfredoMacri\_doc@gmail.com, 11, 17);
1. m3 (matricula: 3, nombre: Paloma, apellido: Isern, dirección: San Martin 995, teléfono: 432564, 17167456, paloiser\_doc@gmail.com, 11, 17);
1. m4 (matricula: 4, nombre: Franco, apellido:  Huarte, dirección: Gaucho Rivero 242, teléfono: 666543, 17221496, huarte@gmail.com", 11, 17);
1. m5 (matricula: 5, nombre: "Jorge", apellido: Gogorza, dirección: San Lorenzo 323, teléfono: 324567, 13545423, jorgegogorza\_doc@gmail.com, 11, 17);
1. m6 (matricula: 6, nombre: Franco, apellido: Raineri, dirección: Las Heras 1368, teléfono: 876545, 24568798, francoraineri\_doc@gmail.com, 11, 17);

- **Pacientes:** 
1. p1(nombre: Juan, apellido: Ignacio, dirección: Alsina 200, teléfono: 450450, email: <juani@gmail.com>, obra social: osde, número de afiliado: 134545)
1. p2(nombre: Juan, apellido: Pablo, dirección: Garibaldi 300, teléfono: 415415, email: <juanpa@gmail.com>, obra social: osde, número de afiliado: 131313)

- Turnos:
1. T1(paciente: p1, médico: m1, fecha: 2022-01-01, horario:17)
1. T2(paciente: p2, médico: m1, fecha: 2022-01-02, horario:16)
1. T3(paciente: p1, médico: m2, fecha: 2022-01-03, horario:14)
1. T4(paciente: p2, médico: m3, fecha: 2022-01-01, horario:15)
1. T5(paciente: p1, médico: m4, fecha: 2022-01-01, horario:15)
1. T6(paciente: p1, médico: m5, fecha: 2022-01-04, horario:11)

**Datos de Entrada**

1. **Ingrese mail:** <lorena@gmail.com>
1. **Ingrese contraseña:** 2

**Ingreso con éxito**

1. **Cancelar turno**
1. **Reagendar turno**
1. **Salir**
1. **Escribe una de las opciones:** 2

**Eligio la opción 2: reagendar turno.**

1. **Ingrese primer nombre del médico:** Jorge
1. **Ingrese apellido del médico:** Gogorza

**Ingrese fecha y hora del turno a reagendar:**

1. **Ingrese día del turno:** 4
1. **Ingrese mes del turno:** 1
1. **Ingrese año del turno:** 2022
1. **Ingrese hora del turno:** 11

**Ingrese la nueva fecha y hora** 

1. **Ingrese día del turno:** 7
1. **Ingrese mes del turno:** 6
1. **Ingrese año del turno:** 2022
1. **Ingrese hora del turno:** 14

**El turno se reagendo con éxito**

1. **Escribe una de las opciones:** 3



# **Datos de Salida esperado**

¡El turno se reagendó con exito!

Turno de [paciente=Juan Ignacio, medico=Jorge Gogorza, fechaturno=2022-06-07, horaturno: 14 hs]

#
# **Datos de Salida obtenidos**

¡El turno se reagendó con exito!

Turno de [paciente=Juan ignacio, medico=Jorge Gogorza, fechaturno=2022-06-07, horaturno: 14 hs]

# **Comentarios**

El testing salió bien, la funcionalidad cumple lo requerido.
