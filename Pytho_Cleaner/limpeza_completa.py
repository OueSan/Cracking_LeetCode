import os
import shutil
import subprocess

def limpar_temp():
    # Lista de diretórios temporários
    temp_paths = [
        os.environ['TEMP'],
        r'C:\Windows\Temp',
        r'C:\Windows\SoftwareDistribution\Download',
        r'C:\Windows\Prefetch'
    ]
    
    # Limpar os arquivos dentro dos diretórios temporários
    for path in temp_paths:
        try:
            if os.path.exists(path):
                for root, dirs, files in os.walk(path, topdown=False):
                    for file in files:
                        os.remove(os.path.join(root, file))
                    for dir in dirs:
                        shutil.rmtree(os.path.join(root, dir))
                print(f"Limpando {path}")
        except Exception as e:
            print(f"Erro ao limpar {path}: {e}")

def esvaziar_lixeira():
    try:
        # Esvaziar a lixeira
        recycle_bin = r'C:\$Recycle.Bin'
        shutil.rmtree(recycle_bin)
        print("Lixeira esvaziada!")
    except Exception as e:
        print(f"Erro ao esvaziar a lixeira: {e}")

def flush_dns():
    try:
        # Executar o comando para limpar o cache DNS
        subprocess.run("ipconfig /flushdns", check=True, shell=True)
        print("Cache DNS limpo!")
    except subprocess.CalledProcessError as e:
        print(f"Erro ao limpar o cache DNS: {e}")

if __name__ == "__main__":
    print("Iniciando limpeza...")
    limpar_temp()        # Limpar arquivos temporários
    esvaziar_lixeira()   # Esvaziar a lixeira
    flush_dns()          # Limpar o cache DNS
    print("Limpeza concluída!")
