import { Freelancer } from "./freelancer";
import { Servico } from "./servico";

export class Proposta{
    idProposta?: number;
    descricaoProposta?: string;
    dataProposta?: string;
    dataAvaliacao?: string;
    valorProposta?: number;
    valorAvaliacao?: number;
    observacaoProposta?: string;
    servico: Servico = new Servico();
    freelancer: Freelancer = new Freelancer();
}