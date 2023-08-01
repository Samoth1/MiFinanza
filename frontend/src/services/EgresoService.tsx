import axios from 'axios';

const url = 'http://localhost:8080/egreso';

class EgresoService {
    nuevoEgreso(fecha: Date, tipodoc: string, numdoc: string, motivo: string, dinero: BigInteger) {
        const proveedor = {
          fecha: fecha,
          tipodoc: tipodoc,
          numdoc: numdoc,
          motivo: motivo,
          dinero: dinero
        };
        return axios.post(url);
      }
}

const instance = new EgresoService();
export default instance;