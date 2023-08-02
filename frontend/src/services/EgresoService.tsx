import axios from 'axios';

const url = 'http://localhost:8080/egreso';

class EgresoService {
    nuevoEgreso(fecha: any, tipodoc: string, numdoc: string, motivo: string, dinero: number) {
        const egreso = {
          fecha: fecha,
          tipodoc: tipodoc,
          numdoc: numdoc,
          motivo: motivo,
          dinero: dinero
        };
        return axios.post(url, egreso);
      }
}

const instance = new EgresoService();
export default instance;