@extends('layout.site')

@section('titulo','Cadastro de Cliente')

@section('conteudo')
      <form class="form-horizontal" action="{{route('cliente.alterar')}}" method="post" enctype="multipart/form-data">
        {{ csrf_field() }}
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="id" value="{{isset($cliente->id) ? $cliente->id : ''}}">
            @include('cliente._form')
            <div class="form-group">
                <label class="col-md-2 control-label" for="Cadastrar"></label>
                <div class="col-md-8">
                    <button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
                    <button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
                </div>
            </div>
        </fieldset>
      </form>
@endsection