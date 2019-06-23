<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function(){
    return view('welcome');
});
Route::get('/cliente',['as' => 'cliente', 'uses' => 'ClienteController@index']);
Route::post('/cliente',['as' => 'cliente.salvar', 'uses'=>'ClienteController@salvar']);
Route::put('/cliente',['as' => 'cliente.alterar', 'uses' => 'ClienteController@alterar']);
Route::get('/cliente/cadastrar', ['as' => 'cliente.cadastrar', 'uses' => 'ClienteController@cadastrar']);
Route::get('/cliente/editar/{id}', ['as' => 'cliente.editar', 'uses' => 'ClienteController@editar']);
Route::get('/cliente/deletar/{id}', ['as' => 'cliente.deletar', 'uses' => 'ClienteController@deletar']);