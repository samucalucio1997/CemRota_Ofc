import React from "react";
import { Navigate, Outlet, useNavigate } from "react-router-dom";
import { getToken } from "../services/auth";

interface PrivateProps {
  children: React.ReactNode;
}

const PrivateRoute = ({ children }: PrivateProps) => {
  const navigate = useNavigate();
  // Implemente sua lógica de verificação de autenticação aqui
  const token = getToken();
  const isAuthenticated = token ? true : false; // Exemplo usando localStorage


  return token ? children : navigate("/login"); // Renderiza o componente filho se autenticado
};

export default PrivateRoute;
