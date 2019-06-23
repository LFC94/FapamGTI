@extends('layout.site')

@section('titulo','Cadastro de Cliente')

@section('conteudo')
      <form class="form-horizontal" action="{{route('cliente.salvar')}}" method="post" enctype="multipart/form-data">
        <fieldset>
            {{ csrf_field() }}
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


