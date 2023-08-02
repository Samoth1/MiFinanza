import React, { Component, ChangeEvent } from 'react';
import ResumenMovService from '../services/ResumenMovService';
import NavBar from './NavbarComponent';
import { Form, ButtonToolbar, Button, SelectPicker, Table } from 'rsuite';
import '../App.css';

interface NuevoResumenState {
  fecha1: any;
  fecha2: any,
  res: any,
}

interface ResumenItem {
  fecha: Date;
  tipo_doc: string;
  num_doc: string;
  motivo: string;
  ingreso: number;
  salida: number;
  saldo: number;
}

class NuevoResumenComponent extends Component<{}, NuevoResumenState> {
  constructor(props: {}) {
    super(props);
    this.state = {
      fecha1: '',
      fecha2: '',
      res: [] as ResumenItem[]
    };
  }

  changeFecha1Handler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ fecha1: event.target.value.replace(/-/g, '/') });
  };

  changeFecha2Handler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ fecha2: event.target.value.replace(/-/g, '/') });
  };

  crearResumen = (e: React.FormEvent) => {
    e.preventDefault();
    ResumenMovService.mostrarResumen(
      this.state.fecha1,
      this.state.fecha2,
    ).then((res) => {
      this.setState({ res: res.data as ResumenItem[]})
      console.log(this.state)
    });
  };

  render() {

    return (
    
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          justifyContent: 'center'
        }}
      >
        <NavBar></NavBar>
        <h1>Mostrar Resumen</h1>
        <div style={{ width: '1000px' }}></div>
        <Form>

          <Form.Group onChange={this.changeFecha1Handler}>
            <Form.ControlLabel>Fecha inicio</Form.ControlLabel>
            <Form.Control name="fecha" type="date"/>
          </Form.Group>

          <Form.Group onChange={this.changeFecha2Handler}>
            <Form.ControlLabel>Fecha termino</Form.ControlLabel>
            <Form.Control name="fecha" type="date"/>
          </Form.Group>

          <Form.Group>
            <ButtonToolbar>
              <Button
                appearance="primary"
                style={{ width: 300 }}
                onClick={this.crearResumen}
              >
                Obtener resumen
              </Button>
            </ButtonToolbar>
          </Form.Group>
        </Form>
        <table className ="styled-table">
          <thead>
            <tr>
              <th>Fecha</th>
              <th>Tipo de Doc</th>
              <th>Número de Doc</th>
              <th>Motivo</th>
              <th>Ingreso</th>
              <th>Salida</th>
              <th>Saldo</th>
            </tr>
          </thead>
          <tbody>
          {this.state.res.map((item:ResumenItem, index: number) => (
            <tr key={index}>
              <td>{item.fecha.toString().substring(0,10)}</td>
              <td>{item.tipo_doc}</td>
              <td>{item.num_doc}</td>
              <td>{item.motivo}</td>
              <td>{item.ingreso}</td>
              <td>{item.salida}</td>
              <td>{item.saldo}</td>
            </tr>
          ))}
          </tbody>

        </table>
      </div>
    );
  }
}



export default NuevoResumenComponent;