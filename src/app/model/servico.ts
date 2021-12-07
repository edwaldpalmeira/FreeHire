import { Cliente } from "./cliente";

export class Servico{
    idServico?: number;
    nomeServico?: string;
    descricaoServico?: string;
    valorServico?: number;
    valorAvaliacao?: number;
    observacaoServico?: string;
    cliente: Cliente = new Cliente();
}