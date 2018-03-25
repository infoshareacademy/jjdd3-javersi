<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
    <div class="container">
        <a href="../" class="navbar-brand">Charging Point Search</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <#if userSessionName??>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="search">Search <span class="caret"></span></a>
                        <div class="dropdown-menu" aria-labelledby="search">
                            <a class="dropdown-item" href="../find-the-closest">Nearest</a>
                            <a class="dropdown-item" href="../find-the-closest-in-radius">In given radius</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="../find-the-closest-by-address">Nearest by address</a>
                            <a class="dropdown-item" href="../find-the-closest-in-radius-by-address">In given radius by address</a>
                            <div class="dropdown-divider"> </div>
                            <a class="dropdown-item" href="../search-by-town">By town name</a>
                            <a class="dropdown-item" href="../search-by-country">By country name</a>
                        </div>
                    </li>
                    <#if userAdmin??>
                        <#if userAdmin>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="administration">Administration <span class="caret"></span></a>
                                <div class="dropdown-menu" aria-labelledby="administration">
                                    <a class="dropdown-item" href="../administration/json-upload">JSON file upload</a>
                                    <a class="dropdown-item" href="../administration/load-data">Upload data from api</a>
                                    <a class="dropdown-item" href="../administration/promoted-settings">Promoted Charging Points settings</a>
                                    <a class="dropdown-item" href="../administration/properties">Properties</a>
                                </div>
                            </li>
                       </#if>
                    </#if>
                    <li class="nav-item">
                        <a class="nav-link" href="../statistics">Statistics</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../about">About</a>
                    </li>
                </ul>
                <ul class="navbar-nav navbar-right">
                    <li class="nav-item">
                        <a class="nav-link" href="../logout">Logout ${userSessionName}</a>
                    </li>

                </ul>
            <#else>
             <ul class="navbar-nav mr-auto">
             </ul>
                 <ul class="navbar-nav navbar-right">
                     <li class="nav-item">
                         <a class="nav-link" href="../login">Login</a>
                     </li>
                 </ul>
            </#if>
        </div>
    </div>
</div>

