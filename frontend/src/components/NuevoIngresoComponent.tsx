import React, { Component, ChangeEvent } from 'react';
import IngresoService from '../services/IngresoService';
import ResumenMovService from '../services/ResumenMovService';
import NavBar from './NavbarComponent';
import { Form, ButtonToolbar, Button, SelectPicker } from 'rsuite';

interface NuevoIngresoState {
  fecha: any;
  numdoc: string;
  dinero: number;
}

class NuevoIngresoComponent extends Component<{}, NuevoIngresoState> {
  constructor(props: {}) {
    super(props);
    this.state = {
      fecha: '',
      numdoc: '',
      dinero: 0
    };
  }

  changeFechaHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ fecha: event.target.value });
  };

  changeNumDocHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ numdoc: event.target.value });
  };

  changeDineroHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ dinero: parseFloat(event.target.value) });
  };

  saveIngreso = (e: React.FormEvent) => {
    e.preventDefault();
    IngresoService.nuevoIngreso(
      this.state.fecha,
      this.state.numdoc,
      this.state.dinero
      ).then((res) => {
        this.saveResumen().then((res2) => {
          window.alert('Se registro el ingreso');
          window.location.href = '/home';
        })
      });
    };

  saveResumen = () => {
    return ResumenMovService.nuevoResumen(
      this.state.fecha,
      "Recibo",
      this.state.numdoc,
      this.state.dinero
    )
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
        <h1>Nuevo Ingreso</h1>
        <div style={{ width: '1000px' }}></div>
        <Form>

          <Form.Group onChange={this.changeFechaHandler}>
            <Form.ControlLabel>Fecha</Form.ControlLabel>
            <Form.Control name="fecha" type="date"/>
          </Form.Group>

          <Form.Group onChange={this.changeNumDocHandler}>
            <Form.ControlLabel>Numero documento</Form.ControlLabel>
            <Form.Control name="numdoc" />
          </Form.Group>

          <Form.Group onChange={this.changeDineroHandler}>
            <Form.ControlLabel>Dinero a ingresar</Form.ControlLabel>
            <Form.Control name="dinero" />
          </Form.Group>

          <Form.Group>
            <ButtonToolbar>
              <Button
                appearance="primary"
                style={{ width: 300 }}
                onClick={this.saveIngreso}
              >
                Registrar ingreso
              </Button>
            </ButtonToolbar>
          </Form.Group>
        </Form>
      </div>
    );
  }
}

export default NuevoIngresoComponent;