import axios from 'axios';

const url = 'http://localhost:8080/ingreso';

class IngresoService {
    nuevoIngreso(fecha: Date, motivo: string, dinero: BigInteger) {
        const ingreso = {
          fecha: fecha,
          motivo: motivo,
          dinero: dinero
        };
        return axios.post(url);
      }
}

const instance = new IngresoService();
export default instance;