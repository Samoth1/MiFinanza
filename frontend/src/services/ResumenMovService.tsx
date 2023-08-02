import axios from 'axios';

const url = 'http://localhost:8080/resumenmov';

class ResumenMovService {

    nuevoResumen(fecha: any, tipodoc: string, numdoc: string, saldo: number) {
        const resumen = {
          fecha: fecha,
          tipodoc: tipodoc,
          numdoc: numdoc,
          saldo: saldo
        };
        return axios.post(url, resumen);
      }

    mostrarResumen(fecha1: any, fecha2: any){
      return axios.get(`${url}?fecha1=${fecha1}&fecha2=${fecha2}`);
    }

}

const instance = new ResumenMovService();
export default instance;