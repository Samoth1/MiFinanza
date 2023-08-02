import React from 'react';
import { Routes, Route} from "react-router-dom";
import "rsuite/dist/rsuite.min.css";
import HomeComponent from "./components/HomeComponent";
import IngresoComponent from "./components/NuevoIngresoComponent"
import EgresoComponent from "./components/NuevoEgresoComponent"
import ResumenComponent from "./components/ResumenComponent"

function AppRouter() {
  return (
    <Routes>
        <Route path="/home" element={<HomeComponent />} />
        <Route path="/ingreso" element={<IngresoComponent />} />
        <Route path="/egreso" element={<EgresoComponent />} />
        <Route path="/resumen" element={<ResumenComponent />} />
    </Routes>
  );
}

export default AppRouter;