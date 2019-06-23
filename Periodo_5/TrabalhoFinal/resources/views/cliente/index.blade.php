@extends('layout.site')

@section('titulo','Cadastro de Cliente')
    
@section('conteudo')
    <div class="container">
    <h3 class="center">Lista de Cientes</h3>
    <div class="row">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">CPF</th>
            <th scope="col">Telefone</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          @foreach($clientes as $cliente)
            <tr>
              <td>{{ $cliente->id }}</td>
              <td>{{ $cliente->nome }}</td>
              <td>{{ $cliente->cpf }}</td>
              <td>{{ $cliente->telefone }}</td>
              <td>
                <a class="btn btn-info" href="{{ route('cliente.editar',$cliente->id)  }}">Editar</a>
                <a class="btn btn-danger" href="{{ route('cliente.deletar',$cliente->id) }}">Deletar</a>
              </td>
            </tr>
          @endforeach
        </tbody>
      </table>
      <a href="{{ route('cliente.cadastrar')}}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Cadastrar</a>    
    </div>
@endsection