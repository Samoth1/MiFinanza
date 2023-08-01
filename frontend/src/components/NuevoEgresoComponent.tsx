import React, { Component, ChangeEvent } from 'react';
import EgresoService from '../services/EgresoService';
import NavBar from './NavbarComponent';
import { Form, ButtonToolbar, Button, SelectPicker } from 'rsuite';

interface NuevoEgresoState {
  fecha: Date;
  tipodoc: string;
  numdoc: string;
  motivo: string;
  dinero: Integer;
}


class NuevoEgresoComponent extends Component<{}, NuevoEgresoState> {
  constructor(props: {}) {
    super(props);
    this.state = {
      codigo: '',
      nombre: '',
      categoria: '',
      retencion: ''
    };
  }

  changeFechaHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ fecha: event.target.value });
  };

  changeTipoDocHandler = (value: any) => {
    this.setState({ tipodoc: value });
  };

  changeNumDocHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ numdoc: event.target.value });
  };

  changeMotivoHandler = (value: any) => {
    this.setState({ motivo: value });
  };

  changeDineroHandler = (event: ChangeEvent<HTMLInputElement>) => {
    this.setState({ dinero: event.target.value });
  };

  saveEgreso = (e: React.FormEvent) => {
    e.preventDefault();
    EgresoService.nuevoEgreso(
      this.state.fecha,
      this.state.tipodoc,
      this.state.numdoc,
      this.state.motivo,
      this.state.dinero
    ).then((res) => {
      window.alert('Se registro el egreso');
      window.location.href = '/proveedor';
    });
  };

  render() {
    
    const dataTipoDoc = ['Boleta', 'Factura'].map((tipodoc) => ({
      label: tipodoc,
      value: tipodoc
    }));

    const dataMotivo = ['Articulos de oficina', 'Productos de limpieza', 'Reparaciones', 'Combustibles', 'Taxis', 'Alimentacion', 'Varios'].map((motivo) => ({
      label: motivo,
      value: motivo
    }));

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
        <h1>Nuevo Egreso</h1>
        <div style={{ width: '1000px' }}></div>
        <Form>

          //Convertir a fecha
          <Form.Group onChange={this.changeFechaHandler}>
            <Form.ControlLabel>Fecha</Form.ControlLabel>
            <Form.Control name="fecha"/>
          </Form.Group>

          <Form.Group>
            <p>Tipo documento</p>
            <SelectPicker
              data={dataTipoDoc}
              searchable={false}
              style={{ width: 300 }}
              onChange={this.changeTipoDocHandler}
            />
          </Form.Group>

          <Form.Group onChange={this.changeNumDocHandler}>
            <Form.ControlLabel>Numero documento</Form.ControlLabel>
            <Form.Control name="numdoc" />
          </Form.Group>

          <Form.Group>
            <p>Motivo</p>
            <SelectPicker
              data={dataMotivo}
              searchable={false}
              style={{ width: 300 }}
              onChange={this.changeMotivoHandler}
            />
          </Form.Group>

          <Form.Group onChange={this.changeDineroHandler}>
            <Form.ControlLabel>Dinero a egresar</Form.ControlLabel>
            <Form.Control name="dinero" />
          </Form.Group>

          <Form.Group>
            <ButtonToolbar>
              <Button
                appearance="primary"
                style={{ width: 300 }}
                onClick={this.saveEgreso}
              >
                Registrar egreso
              </Button>
            </ButtonToolbar>
          </Form.Group>
        </Form>
      </div>
    );
  }
}

export default NuevoEgresoComponent;