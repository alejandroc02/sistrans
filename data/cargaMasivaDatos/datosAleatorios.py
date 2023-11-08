import csv
import random
from datetime import datetime, timedelta
import random
# Configuración de las restricciones de las tablas
equipos_id_min = 1
equipos_id_max = 500
costo_min = 10.0
costo_max = 500.0

capacidad_min = 10
capacidad_max = 200
estilos = ['Jazz', 'Salsa', 'Bachata', 'Crossover', 'Baladas']
servicios_tipo_bares = ['bar']

clientes_num_documento_min = 10000
clientes_num_documento_max = 99999

# Función para generar una fecha aleatoria
def generar_fecha():
    start_date = datetime(2023, 1, 1)
    end_date = datetime(2023, 12, 31)
    return start_date + timedelta(days=random.randint(0, (end_date - start_date).days))

# Función para generar una hora aleatoria
def random_time(start, end):
    format = '%H:%M:%S'
    stime = datetime.strptime(start, format)
    etime = datetime.strptime(end, format)
    delta = etime - stime
    seconds = random.randint(0, delta.total_seconds())
    return (stime + timedelta(seconds=seconds)).time().strftime(format)

# Función para generar datos para la tabla "adicionales"
def generar_datos_adicionales():
    with open('data\cargaMasivaDatos\csv\data_adicionales.csv', 'w', newline='') as csvfile:
        fieldnames = ['reunion_id', 'equipos_id', 'costo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reunion_id in range(1, 100):  # Genera 750,000 registros
            equipos_id = random.randint(equipos_id_min, equipos_id_max)
            costo = round(random.uniform(costo_min, costo_max), 2)
            writer.writerow({'reunion_id': reunion_id, 'equipos_id': equipos_id, 'costo': costo})

# Función para generar datos para la tabla "bares"
def generar_datos_bares():
    with open('data\cargaMasivaDatos\csv\data_bares.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'estilo', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 75001):  # Genera 75,000 registros
            capacidad = random.randint(capacidad_min, capacidad_max)
            estilo = random.choice(estilos)
            servicios_tipo = random.choice(servicios_tipo_bares)
            writer.writerow({'id': id, 'capacidad': capacidad, 'estilo': estilo, 'servicios_tipo': servicios_tipo})

# Función para generar datos para la tabla "checkin"
def generar_datos_checkin():
    with open('data\cargaMasivaDatos\csv\data_checkin.csv', 'w', newline='') as csvfile:
        fieldnames = ['reservas_id', 'clientes_num_documento', 'fecha_ingreso']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reservas_id in range(1, 100):  # Genera 750,000 registros
            clientes_num_documento = random.randint(clientes_num_documento_min, clientes_num_documento_max)
            fecha_ingreso = generar_fecha().strftime('%Y-%m-%d')
            writer.writerow({'reservas_id': reservas_id, 'clientes_num_documento': clientes_num_documento, 'fecha_ingreso': fecha_ingreso})

# Genera datos para las tres tablas
generar_datos_adicionales()
generar_datos_bares()
generar_datos_checkin()

print('Datos generados para las tablas "adicionales", "bares" y "checkin".') 

# Función para generar datos para la tabla "checkouts" 
def generar_datos_checkouts():
    with open('data\cargaMasivaDatos\csv\data_checkouts.csv', 'w', newline='') as csvfile:
        fieldnames = ['reservas_id', 'habitacion_id', 'fecha_salida']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reservas_id in range(1, 100):  # Genera 750,000 registros
            habitacion_id = random.randint(1, 1000)  # Asegúrate de que el rango es adecuado
            fecha_salida = generar_fecha().strftime('%Y-%m-%d')
            writer.writerow({'reservas_id': reservas_id, 'habitacion_id': habitacion_id, 'fecha_salida': fecha_salida})

# Genera datos para la tabla "checkouts"
generar_datos_checkouts()
print('Datos generados para la tabla "checkouts".')

# Función para generar datos para la tabla "clientes"
def generar_datos_clientes():
    tipos_documento = ['cc', 'ce', 'cif', 'ti', 'pasaporte']

    with open('data\cargaMasivaDatos\csv\data_clientes.csv', 'w', newline='') as csvfile:
        fieldnames = ['tipo_documento', 'num_documento', 'nombre', 'correo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for num_documento in range(clientes_num_documento_min, clientes_num_documento_max + 1):
            tipo_documento = random.choice(tipos_documento)
            nombre = f'Cliente {num_documento}'
            correo = f'cliente{num_documento}@example.com'
            writer.writerow({'tipo_documento': tipo_documento, 'num_documento': num_documento, 'nombre': nombre, 'correo': correo})

# Genera datos para la tabla "clientes"
generar_datos_clientes()
print('Datos generados para la tabla "clientes".')

# Función para generar datos para la tabla "conferencias"
def generar_datos_conferencias():
    with open('data\cargaMasivaDatos\csv\data_conferencias.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'costo_hora', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(capacidad_min, capacidad_max)
            costo_hora = round(random.uniform(costo_min, costo_max), 2)
            servicios_tipo = 'Conferencia'
            writer.writerow({'id': id, 'capacidad': capacidad, 'costo_hora': costo_hora, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "conferencias"
generar_datos_conferencias()
print('Datos generados para la tabla "conferencias".')

# Función para generar datos para la tabla "consumos"
def generar_datos_consumos():
    with open('data\cargaMasivaDatos\csv\data_consumos.csv', 'w', newline='') as csvfile:
        fieldnames = ['habitacion_id', 'servicios_tipo', 'descripcion', 'costo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for habitacion_id in range(1, 100):  # Genera 750,000 registros
            servicios_tipo = 'bar'  # Ajusta según tus restricciones
            descripcion = f'Descripción del consumo {habitacion_id}'
            costo = round(random.uniform(0, 100), 2)  # Ajusta el rango de costo
            writer.writerow({'habitacion_id': habitacion_id, 'servicios_tipo': servicios_tipo, 'descripcion': descripcion, 'costo': costo})

# Genera datos para la tabla "consumos"
generar_datos_consumos()
print('Datos generados para la tabla "consumos".')

# Función para generar datos para la tabla "equipos"
def generar_datos_equipos():
    with open('data\cargaMasivaDatos\csv\data_equipos.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'descripcion']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Equipo {id}'
            descripcion = f'Descripción del equipo {id}'
            writer.writerow({'id': id, 'nombre': nombre, 'descripcion': descripcion})

# Genera datos para la tabla "equipos"
generar_datos_equipos()
print('Datos generados para la tabla "equipos".')

# Función para generar datos para la tabla "gimnasios"
def generar_datos_gimnasios():
    with open('data\cargaMasivaDatos\csv\data_gimnasios.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'hora_inicio', 'hora_fin', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(1, 100)  # Ajusta el rango de capacidad
            hora_inicio = random.randint(1, 12)  # Ajusta el rango de hora_inicio
            hora_fin = hora_inicio + random.randint(1, 3)  # Ajusta el rango de hora_fin
            servicios_tipo = 'gimnasio'
            writer.writerow({'id': id, 'capacidad': capacidad, 'hora_inicio': hora_inicio, 'hora_fin': hora_fin, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "gimnasios"
generar_datos_gimnasios()
print('Datos generados para la tabla "gimnasios".')

# Función para generar datos para la tabla "gratis"
def generar_datos_gratis():
    with open('data\cargaMasivaDatos\csv\data_gratis.csv', 'w', newline='') as csvfile:
        fieldnames = ['conferencia_id', 'equipos_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for conferencia_id in range(1, 100):  # Genera 750,000 registros
            equipos_id = random.randint(1, 1000)  # Ajusta el rango de equipos_id
            writer.writerow({'conferencia_id': conferencia_id, 'equipos_id': equipos_id})

# Genera datos para la tabla "gratis"
generar_datos_gratis()
print('Datos generados para la tabla "gratis".')

# Función para generar datos para la tabla "habitaciones"
def generar_datos_habitaciones():
    with open('data\cargaMasivaDatos\csv\data_habitaciones.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'precio', 'tipohab_id_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(1, 10)  # Ajusta el rango de capacidad
            precio = round(random.uniform(50, 500), 2)  # Ajusta el rango de precio
            tipohab_id_tipo = random.randint(1, 10)  # Ajusta el rango de tipohab_id_tipo
            writer.writerow({'id': id, 'capacidad': capacidad, 'precio': precio, 'tipohab_id_tipo': tipohab_id_tipo})

# Genera datos para la tabla "habitaciones"
generar_datos_habitaciones()
print('Datos generados para la tabla "habitaciones".')

# Función para generar datos para la tabla "internets"
def generar_datos_internets():
    with open('data\cargaMasivaDatos\csv\data_internets.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'costo_dia', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(1, 100)  # Ajusta el rango de capacidad
            costo_dia = round(random.uniform(5, 50), 2)  # Ajusta el rango de costo_dia
            servicios_tipo = 'internet'
            writer.writerow({'id': id, 'capacidad': capacidad, 'costo_dia': costo_dia, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "internets"
generar_datos_internets()
print('Datos generados para la tabla "internets".')

# Función para generar datos para la tabla "lavanderias"
def generar_datos_lavanderias():
    with open('data\cargaMasivaDatos\csv\data_lavanderias.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'tipo_prenda', 'cantidad_prendas', 'costo', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            tipo_prenda = random.choice(['Camisa', 'Pantalón', 'Vestido', 'Saco', 'Camiseta', 'Shorts', 'Calcetines'])
            cantidad_prendas = random.randint(1, 10)  # Ajusta el rango de cantidad_prendas
            costo = round(random.uniform(5, 50), 2)  # Ajusta el rango de costo
            servicios_tipo = 'lavadoSecadoEmbolado'
            writer.writerow({'id': id, 'tipo_prenda': tipo_prenda, 'cantidad_prendas': cantidad_prendas, 'costo': costo, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "lavanderias"
generar_datos_lavanderias()
print('Datos generados para la tabla "lavanderias".')

# Función para generar datos para la tabla "ofrecen"
def generar_datos_ofrecen():
    with open('data\cargaMasivaDatos\csv\data_ofrecen.csv', 'w', newline='') as csvfile:
        fieldnames = ['spas_id', 'serviciosspa_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for spas_id in range(1, 100):  # Genera 750,000 registros
            serviciosspa_id = random.randint(1, 1000)  # Ajusta el rango de serviciosspa_id
            writer.writerow({'spas_id': spas_id, 'serviciosspa_id': serviciosspa_id})

# Genera datos para la tabla "ofrecen"
generar_datos_ofrecen()
print('Datos generados para la tabla "ofrecen".')

# Función para generar datos para la tabla "piscinas"
def generar_datos_piscinas():
    with open('data\cargaMasivaDatos\csv\data_piscinas.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'profundidad_m', 'capacidad', 'hora_inicio', 'hora_fin', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            profundidad_m = random.randint(1, 3)  # Ajusta el rango de profundidad_m
            capacidad = random.randint(10, 100)  # Ajusta el rango de capacidad
            hora_inicio = random_time("08:00:00", "12:00:00")  # Genera hora de inicio aleatoria
            hora_fin = random_time("14:00:00", "20:00:00")  # Genera hora de fin aleatoria
            servicios_tipo = 'piscina'
            writer.writerow({'id': id, 'profundidad_m': profundidad_m, 'capacidad': capacidad, 'hora_inicio': hora_inicio, 'hora_fin': hora_fin, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "piscinas"
generar_datos_piscinas()
print('Datos generados para la tabla "piscinas".')

# Función para generar datos para la tabla "planes_consumo"
def generar_datos_planes_consumo():
    with open('data\cargaMasivaDatos\csv\data_planes_consumo.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'estadia_min', 'costo', 'desc_reserva', 'desc_bar', 'desc_rest', 'desc_servicio']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Plan_{id}'
            estadia_min = random.randint(1, 10)  # Ajusta el rango de estadia_min
            costo = round(random.uniform(50, 200), 2)  # Ajusta el rango de costo
            desc_reserva = random.uniform(0, 1)  # Ajusta el rango de desc_reserva
            desc_bar = random.uniform(0, 1)  # Ajusta el rango de desc_bar
            desc_rest = random.uniform(0, 1)  # Ajusta el rango de desc_rest
            desc_servicio = random.uniform(0, 1)  # Ajusta el rango de desc_servicio
            writer.writerow({'id': id, 'nombre': nombre, 'estadia_min': estadia_min, 'costo': costo, 'desc_reserva': desc_reserva, 'desc_bar': desc_bar, 'desc_rest': desc_rest, 'desc_servicio': desc_servicio})

# Genera datos para la tabla "planes_consumo"
generar_datos_planes_consumo()
print('Datos generados para la tabla "planes_consumo".')

# Función para generar datos para la tabla "prestan"
def generar_datos_prestan():
    with open('data\cargaMasivaDatos\csv\data_prestan.csv', 'w', newline='') as csvfile:
        fieldnames = ['serviciosprestamo_id', 'utensilios_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for serviciosprestamo_id in range(1, 100):  # Genera 750,000 registros
            utensilios_id = random.randint(1, 1000)  # Ajusta el rango de utensilios_id
            writer.writerow({'serviciosprestamo_id': serviciosprestamo_id, 'utensilios_id': utensilios_id})

# Genera datos para la tabla "prestan"
generar_datos_prestan()
print('Datos generados para la tabla "prestan".')

# Función para generar datos para la tabla "productos_bar"
def generar_datos_productos_bar():
    with open('data\cargaMasivaDatos\csv\data_productos_bar.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'precio']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Producto_{id}'
            precio = round(random.uniform(2, 20), 2)  # Ajusta el rango de precio
            writer.writerow({'id': id, 'nombre': nombre, 'precio': precio})

# Genera datos para la tabla "productos_bar"
generar_datos_productos_bar()
print('Datos generados para la tabla "productos_bar".')

# Función para generar datos para la tabla "productos_res"
def generar_datos_productos_res():
    with open('data\cargaMasivaDatos\csv\data_productos_res.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'precio']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Producto_{id}'
            precio = round(random.uniform(5, 50), 2)  # Ajusta el rango de precio
            writer.writerow({'id': id, 'nombre': nombre, 'precio': precio})

# Genera datos para la tabla "productos_res"
generar_datos_productos_res()
print('Datos generados para la tabla "productos_res".')

# Función para generar datos para la tabla "productos_super"
def generar_datos_productos_super():
    with open('data\cargaMasivaDatos\csv\data_productos_super.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'precio']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Producto_{id}'
            precio = round(random.uniform(1, 100), 2)  # Ajusta el rango de precio
            writer.writerow({'id': id, 'nombre': nombre, 'precio': precio})

# Genera datos para la tabla "productos_super"
generar_datos_productos_super()
print('Datos generados para la tabla "productos_super".')

# Función para generar datos para la tabla "productos_t"
def generar_datos_productos_t():
    with open('data\cargaMasivaDatos\csv\data_productos_t.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'precio']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Producto_{id}'
            precio = round(random.uniform(1, 50), 2)  # Ajusta el rango de precio
            writer.writerow({'id': id, 'nombre': nombre, 'precio': precio})

# Genera datos para la tabla "productos_t"
generar_datos_productos_t()
print('Datos generados para la tabla "productos_t".')

# Función para generar datos para la tabla "reservan"
def generar_datos_reservan():
    with open('data\cargaMasivaDatos\csv\data_reservan.csv', 'w', newline='') as csvfile:
        fieldnames = ['habitacion_id', 'reservas_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for habitacion_id in range(1, 100):  # Genera 750,000 registros
            reservas_id = random.randint(1, 1000)  # Asigna un ID de reserva aleatorio
            writer.writerow({'habitacion_id': habitacion_id, 'reservas_id': reservas_id})

# Genera datos para la tabla "reservan"
generar_datos_reservan()
print('Datos generados para la tabla "reservan".')

# Función para generar datos para la tabla "reservas"
def generar_datos_reservas():
    with open('data\cargaMasivaDatos\csv\data_reservas.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'fecha_inicio', 'fecha_salida', 'num_personas', 'planesconsumo_id', 'usuarios_num_documento']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            fecha_inicio = generar_fecha().strftime('%Y-%m-%d')
            fecha_salida = (generar_fecha() + timedelta(days=random.randint(1, 30))).strftime('%Y-%m-%d')  # Fecha de salida dentro de 1 a 30 días
            num_personas = random.randint(1, 100)
            planesconsumo_id = random.randint(1, 1000)  # Asigna un ID de plan de consumo aleatorio
            usuarios_num_documento = random.randint(1, 1000)  # Asigna un número de documento de usuario aleatorio
            writer.writerow({'id': id, 'fecha_inicio': fecha_inicio, 'fecha_salida': fecha_salida, 'num_personas': num_personas, 'planesconsumo_id': planesconsumo_id, 'usuarios_num_documento': usuarios_num_documento})

# Genera datos para la tabla "reservas"
generar_datos_reservas()
print('Datos generados para la tabla "reservas".')

# Función para generar datos para la tabla "reservas_serv"
def generar_datos_reservas_serv():
    with open('data\cargaMasivaDatos\csv\data_reservas_serv.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'duracion_hora', 'dia', 'hora', 'habitacion_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            duracion_hora = random.randint(1, 24)
            dia = generar_fecha().strftime('%Y-%m-%d')
            hora = (generar_fecha() + timedelta(hours=random.randint(0, 23))).strftime('%H:%M:%S')  # Hora aleatoria
            habitacion_id = random.randint(1, 1000)  # Asigna un ID de habitación aleatorio
            writer.writerow({'id': id, 'duracion_hora': duracion_hora, 'dia': dia, 'hora': hora, 'habitacion_id': habitacion_id})

# Genera datos para la tabla "reservas_serv"
generar_datos_reservas_serv()
print('Datos generados para la tabla "reservas_serv".')

# Función para generar datos para la tabla "reservas_spa"
def generar_datos_reservas_spa():
    with open('data\cargaMasivaDatos\csv\data_reservas_spa.csv', 'w', newline='') as csvfile:
        fieldnames = ['reservaserv_id', 'spas_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reservaserv_id in range(1, 100):  # Genera 750,000 registros
            spas_id = random.randint(1, 1000)  # Asigna un ID de spa aleatorio
            writer.writerow({'reservaserv_id': reservaserv_id, 'spas_id': spas_id})

# Genera datos para la tabla "reservas_spa"
generar_datos_reservas_spa()
print('Datos generados para la tabla "reservas_spa".')

# Función para generar datos para la tabla "restaurantes"
def generar_datos_restaurantes():
    with open('data\cargaMasivaDatos\csv\data_restaurantes.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'estilo', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(1, 200)
            estilo = random.choice(['Comida rápida', 'Gourmet', 'Buffet', 'Barbecue', 'Cafetería'])
            servicios_tipo =  'restaurante'
            writer.writerow({'id': id, 'capacidad': capacidad, 'estilo': estilo, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "restaurantes"
generar_datos_restaurantes()
print('Datos generados para la tabla "restaurantes".')

# Función para generar datos para la tabla "reuniones"
def generar_datos_reuniones():
    with open('data\cargaMasivaDatos\csv\data_reuniones.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'capacidad', 'costo_hora', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            capacidad = random.randint(1, 100)
            costo_hora = round(random.uniform(50.0, 200.0), 2)
            servicios_tipo = 'reunion'
            writer.writerow({'id': id, 'capacidad': capacidad, 'costo_hora': costo_hora, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "reuniones"
generar_datos_reuniones()
print('Datos generados para la tabla "reuniones".')

# Función para generar datos para la tabla "serv_conferencia"
def generar_datos_serv_conferencia():
    with open('data\cargaMasivaDatos\csv\data_serv_conferencia.csv', 'w', newline='') as csvfile:
        fieldnames = ['reservaserv_id', 'conferencia_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reservaserv_id in range(1, 100):  # Genera 750,000 registros
            conferencia_id = random.randint(1, 1000)  # Asigna un ID de conferencia aleatorio
            writer.writerow({'reservaserv_id': reservaserv_id, 'conferencia_id': conferencia_id})

# Genera datos para la tabla "serv_conferencia"
generar_datos_serv_conferencia()
print('Datos generados para la tabla "serv_conferencia".')

# Función para generar datos para la tabla "serv_reuniones"
def generar_datos_serv_reuniones():
    with open('data\cargaMasivaDatos\csv\data_serv_reuniones.csv', 'w', newline='') as csvfile:
        fieldnames = ['reservaserv_id', 'reunion_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for reservaserv_id in range(1, 100):  # Genera 750,000 registros
            reunion_id = random.randint(1, 1000)  # Asigna un ID de reunión aleatorio
            writer.writerow({'reservaserv_id': reservaserv_id, 'reunion_id': reunion_id})

# Genera datos para la tabla "serv_reuniones"
generar_datos_serv_reuniones()
print('Datos generados para la tabla "serv_reuniones".')

# Función para generar datos para la tabla "servicios_spa"
def generar_datos_servicios_spa():
    with open('data\cargaMasivaDatos\csv\data_servicios_spa.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'costo', 'duracion_min']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = 'Servicio Spa ' + str(id)
            costo = round(random.uniform(50.0, 300.0), 2)
            duracion_min = random.randint(30, 120)
            writer.writerow({'id': id, 'nombre': nombre, 'costo': costo, 'duracion_min': duracion_min})

# Genera datos para la tabla "servicios_spa"
generar_datos_servicios_spa()
print('Datos generados para la tabla "servicios_spa".')

# Función para generar datos para la tabla "servicios"
def generar_datos_servicios():
    tipos_servicios = ['bar', 'gimnasio', 'internet', 'lavadoSecadoEmbolado', 'piscina',
                      'prestamo', 'restaurante', 'salon', 'spa', 'supermercado', 'tienda']
    with open('data\cargaMasivaDatos\csv\data_servicios.csv', 'w', newline='') as csvfile:
        fieldnames = ['tipo', 'descripcion']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for tipo in tipos_servicios:
            descripcion = f'Descripción del servicio {tipo}'
            writer.writerow({'tipo': tipo, 'descripcion': descripcion})

# Genera datos para la tabla "servicios"
generar_datos_servicios()
print('Datos generados para la tabla "servicios".')

# Función para generar datos para la tabla "servicios_prestamo"
def generar_datos_servicios_prestamo():
    with open('data\cargaMasivaDatos\csv\data_servicios_prestamo.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'cantidad', 'devuelto', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            cantidad = random.randint(1, 10)
            devuelto = random.choice([0, 1])
            servicios_tipo = random.choice(['prestamo', 'gimnasio', 'spa', 'internet', 'tienda'])
            writer.writerow({'id': id, 'cantidad': cantidad, 'devuelto': devuelto, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "servicios_prestamo"
generar_datos_servicios_prestamo()
print('Datos generados para la tabla "servicios_prestamo".')

# Función para generar datos para la tabla "serv_asser"
def generar_datos_serv_asser():
    with open('data\cargaMasivaDatos\csv\data_serv_asser.csv', 'w', newline='') as csvfile:
        fieldnames = ['serviciosspa_id', 'servicios_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for serviciosspa_id in range(1, 100):  # Genera 750,000 registros
            servicios_tipo = random.choice(['bar', 'restaurante', 'supermercado', 'tienda'])
            writer.writerow({'serviciosspa_id': serviciosspa_id, 'servicios_tipo': servicios_tipo})

# Genera datos para la tabla "serv_asser"
generar_datos_serv_asser()
print('Datos generados para la tabla "serv_asser".')

# Función para generar datos para la tabla "sirven_res"
def generar_datos_sirven_res():
    with open('data\cargaMasivaDatos\csv\data_sirven_res.csv', 'w', newline='') as csvfile:
        fieldnames = ['restaurantes_id', 'productosres_id']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for _ in range(1000):  # Genera 750,000 registros
            restaurantes_id = random.randint(1, 1000)
            productosres_id = random.randint(1, 1000)
            writer.writerow({'restaurantes_id': restaurantes_id, 'productosres_id': productosres_id})

# Genera datos para la tabla "sirven_res"
generar_datos_sirven_res()
print('Datos generados para la tabla "sirven_res".')

# Función para generar datos para la tabla "tipo_usuarios"
def generar_datos_tipo_usuarios():
    tipos_usuario = ['Administrador', 'Empleado', 'Recepcionista', 'Gerente']
    with open('data\cargaMasivaDatos\csv\data_tipo_usuarios.csv', 'w', newline='') as csvfile:
        fieldnames = ['tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for tipo in tipos_usuario:
            writer.writerow({'tipo': tipo})

# Genera datos para la tabla "tipo_usuarios"
generar_datos_tipo_usuarios()
print('Datos generados para la tabla "tipo_usuarios".')

# Función para generar datos para la tabla "utensilios"
def generar_datos_utensilios():
    with open('data\cargaMasivaDatos\csv\data_utensilios.csv', 'w', newline='') as csvfile:
        fieldnames = ['id', 'nombre', 'costo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for id in range(1, 100):  # Genera 750,000 registros
            nombre = f'Utensilio-{id}'
            costo = round(random.uniform(1, 100), 2)
            writer.writerow({'id': id, 'nombre': nombre, 'costo': costo})

# Genera datos para la tabla "utensilios"
generar_datos_utensilios()
print('Datos generados para la tabla "utensilios".')


# Función para generar datos para la tabla "usuarios"
def generar_datos_usuarios():
    tipos_documento = ['CC', 'CE', 'CIF', 'TI', 'pasaporte']
    nombres = ['Juanita', 'Alejandro', 'Samuel', 'Carlos', 'Santiago', 'Juliana', 'Juan', 'Ernesto', 'Jenny']
    correos = ['correo1@example.com', 'correo2@example.com', 'correo3@example.com', 'correo4@example.com', 'correo5@example.com']
    tipos_usuario = ['Administrador', 'Empleado', 'Recepcionista', 'Gerente']

    with open('data\cargaMasivaDatos\csv\data_usuarios.csv', 'w', newline='') as csvfile:
        fieldnames = ['tipo_documento', 'num_documento', 'nombre', 'correo', 'tiposusuario_tipo']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for _ in range(3000):  # Genera 750,000 registros
            tipo_documento = random.choice(tipos_documento)
            num_documento = random.randint(1, 3000)
            nombre = random.choice(nombres)
            correo = random.choice(correos)
            tiposusuario_tipo = random.choice(tipos_usuario)
            writer.writerow({'tipo_documento': tipo_documento, 'num_documento': num_documento, 'nombre': nombre, 'correo': correo, 'tiposusuario_tipo': tiposusuario_tipo})

# Genera datos para la tabla "usuarios"
generar_datos_usuarios()
print('Datos generados para la tabla "usuarios".')