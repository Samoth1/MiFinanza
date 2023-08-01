import React, { Component } from 'react';
import { Grid, Row, Col } from 'rsuite';

export default class HomeComponent extends Component {
  redireccionar(direccion: string) {
    window.location.href = direccion;
  }

  render() {
    return (
      <Grid>
        <Row>
          <Col xs={8}>
            <h1>Crear Ingreso</h1>
            <button onClick={() => this.redireccionar('/ingreso')}>
              Crear Ingreso
            </button>
          </Col>
          <Col xs={8}>
            <h1>Crear Egreso</h1>
            <button onClick={() => this.redireccionar('/egreso')}>
              Crear Proveedor
            </button>
          </Col>
          <Col xs={8}>
            <h1>Ver resumen</h1>
            <button onClick={() => this.redireccionar('/resumen')}>
                Resumen caja chica
            </button>
          </Col>
        </Row>
        <br /><br /><br /><br /><br /><br />
      </Grid>
    );
  }
}