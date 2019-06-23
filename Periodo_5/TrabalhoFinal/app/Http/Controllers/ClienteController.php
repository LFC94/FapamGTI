<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Cliente;

class ClienteController extends Controller
{   
    public function index(){
        $clientes = Cliente::all();
        return view('cliente.index',compact('clientes'));
    }
    public function cadastrar()
    {
        return view('cliente.adicionar');
    }
    public function editar($id)
    {
        $cliente = Cliente::find($id);
        return view('cliente.editar', compact( 'cliente'));
    }

    public function salvar(Request $request)
    {
        $dados = $request->all();
        Cliente::create($dados);

        return redirect()->route('cliente');
    }

    public function alterar(Request $req)
    {
        $dados = $req->all();
        Cliente::find( $req->id)->update($dados);

        return redirect()->route('cliente');
    }
    public function deletar($id)
    {
        Cliente::find($id)->delete();
        return redirect()->route('cliente');
    }
}
