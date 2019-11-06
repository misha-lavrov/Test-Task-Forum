<#macro addNewToDB path placeholder id>
<div class="form-group row align-items-center justify-content-center">
    <form action="${path}" method="post" class="form-row">
        <input type="hidden" name="id" value="${id}"/>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" placeholder="${placeholder}"/>
        </div>
        <div class="col-sm-2">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>
</#macro>