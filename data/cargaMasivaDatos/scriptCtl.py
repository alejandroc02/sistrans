import os
import pandas as pd

# Carpeta que contiene los archivos CSV
csv_folder = 'data\cargaMasivaDatos\csv'
# Carpeta donde se guardarán los archivos .ctl
ctl_folder = 'data\cargaMasivaDatos\ctl'

# Lista de nombres de las tablas
tables = [
    'tipo_usuarios', 'usuarios','tipo_hab','habitaciones',
    'planes_consumo','reservas','servicios','bares',
    'gimnasios','internets','lavanderias','piscinas',
    'servicios_prestamo','restaurantes','conferencias',
    'reuniones','spas','reservas_serv','reservas_spa',
    'servicios_spa','ofrecen','supermercados',
    'tiendas','consumos','clientes','checkin',
    'reservan','serv_conferencia','serv_reuniones',
    'equipos','adicionales','checkouts','utensilios',
    'productos_bar','productos_res','productos_t',
    'productos_super','venden_super','venden_t','prestan',
    'sirven_bares','sirven_res'
]

for table in tables:
    # Ruta al archivo CSV
    csv_file = os.path.join(csv_folder, f'data_{table}.csv')
    
    # Leer el CSV para obtener los nombres de las columnas
    df = pd.read_csv(csv_file)
    columns = df.columns.tolist()
    
    # Ruta al archivo .ctl
    ctl_file = os.path.join(ctl_folder, f'cargaMasiva_{table}.ctl')
    
    # Generar el contenido del archivo .ctl
    with open(ctl_file, 'w') as ctl:
        ctl.write(f"-- Carga de datos para la tabla \"{table}\"\n")
        ctl.write("LOAD DATA\n")
        ctl.write(f"INFILE '{csv_file}'\n")
        ctl.write(f"APPEND INTO TABLE {table}\n")
        ctl.write("FIELDS TERMINATED BY ','\n")
        ctl.write("(\n")
        for column in columns:
            ctl.write(f"    {column},\n")
        ctl.write(")")
    
    print(f"Archivo .ctl generado para la tabla {table}")

print("Archivos .ctl generados exitosamente.")
