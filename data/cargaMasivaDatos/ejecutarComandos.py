import subprocess

nombre_archivo = "ejecutarConsola.txt"

# Abre el archivo en modo lectura
with open("data\cargaMasivaDatos\ejecutarConsola.txt", "r") as archivo:
    # Lee cada línea del archivo
    lineas = archivo.readlines()

    # Ejecuta cada línea como un comando en la terminal
    for linea in lineas:
        try:
            # Utiliza subprocess para ejecutar el comando en la terminal
            subprocess.run(linea, shell=True, check=True)
        except subprocess.CalledProcessError as e:
            print(f"Error al ejecutar el comando: {linea}")
            print(f"Código de salida: {e.returncode}")
            print(f"Error: {e.stderr}")
        except Exception as e:
            print(f"Error al ejecutar el comando: {linea}")
            print(f"Error: {str(e)}")
