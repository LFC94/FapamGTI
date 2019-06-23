<div class="panel panel-primary">               
    <div class="panel-body">
        <div class="form-group">
            <label class="col-md-2 control-label" for="nome">Nome</label>  
            <div class="col-md-8">
                <input id="nome" name="nome" placeholder="" class="form-control input-md" required="" type="text"
                value="{{isset($cliente->nome) ? $cliente->nome : ''}}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="cpf">CPF</label>  
            <div class="col-md-2">
                <input id="'cpf" name="cpf" placeholder="Apenas números" class="form-control input-md" required="" type="text" maxlength="11" pattern="[0-9]+$"
                 value="{{isset($cliente->cpf) ? $cliente->cpf : ''}}">
            </div>
            
            <label class="col-md-1 control-label" for="telefone">Telefone</label>  
            <div class="col-md-2">
                <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                <input id="telefone" name="telefone" class="form-control" placeholder="XX XXXXX-XXXX" required="" type="text" maxlength="13" pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
                OnKeyPress="formatar('## #####-####', this)" value="{{isset($cliente->telefone) ? $cliente->telefone : ''}}">
                </div>
            </div>
        </div>    
    </div>
</div>