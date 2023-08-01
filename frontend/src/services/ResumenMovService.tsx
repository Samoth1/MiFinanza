import axios from 'axios';

const url = 'http://localhost:8080/resumenmov';

class ResumenMovService {

    nuevoResumen(fecha: Date, tipodoc: string, numdoc: string, motivo: string, saldo: BigInteger) {
        const proveedor = {
          fecha: fecha,
          tipodoc: tipodoc,
          numdoc: numdoc,
          saldo: saldo
        };
        return axios.post(url);
      }

    mostrarResumen(fecha1: Date, fecha2: Date){
      return axios.post(`${url}?fecha1=${fecha1}&fecha2=${fecha2}`);
    }

}

const instance = new ResumenMovService();
export default instance;