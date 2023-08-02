import axios from 'axios';

const url = 'http://localhost:8080/ingreso';

class IngresoService {
    nuevoIngreso(fecha: any, numdoc: string, dinero: number) {
        const ingreso = {
          fecha: fecha,
          numdoc: numdoc,
          dinero: dinero
        };
        return axios.post(url, ingreso);
      }
}

const instance = new IngresoService();
export default instance;