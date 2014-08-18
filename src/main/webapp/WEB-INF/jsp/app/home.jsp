<%--
  Created by IntelliJ IDEA.
  User: rolando
  Date: 14-08-15
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<div class="row">
    <div class="col-md-6">
        <h2><spring:message code="home_search_block_title" /></h2>
        <div class="panel panel-default">
            <div class="panel-heading"></div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group has-feedback">
                        <label for="searchQuery" class="control-label">Le ayudaremos a encontrar lo que desea</label>
                        <input type="text" class="form-control" id="searchQuery" placeholder="Entre la cadena a buscar...">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                    <fieldset>
                        <legend>Podemos guiarte...</legend>
                    </fieldset>
                    <div class="form-group">
                        <label for="category" class="control-label">Filtre por categoría</label>
                        <select id="category" name="category" class="form-control">
                            <option>-Seleccione-</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <div class="col-xs-6">
                            <label for="minPrice" class="control-label">Precio mínimo</label>
                            <input type="number" name="minPrice" id="minPrice" class="form-control">
                        </div>
                        <div class="col-xs-6">
                            <label for="maxPrice" class="control-label">Precio máximo</label>
                            <input type="number" name="maxPrice" id="maxPrice" class="form-control">
                        </div>
                    </div>
                    <div class="pull-right">
                        <button type="submit" class="btn btn-default">Buscar</button>
                    </div>
                    <div class="clearfix"></div>
                </form>
            </div>
            <div class="panel-footer"></div>
        </div>


    </div>
    <div class="col-md-6">
        <h2>Quiéres anunciarte... Únete a nosotros</h2>
        <div class="panel panel-default">
            <div class="panel-heading"></div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email" required="required">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password" required="required">
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Acepto los términos
                            </label>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-default">Entrar</button>
                </form>
            </div>
            <div class="panel-footer"></div>
        </div>

    </div>
</div>
<%@ include file="../common/footer.jsp"%>
