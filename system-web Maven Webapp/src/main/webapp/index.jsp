<html>
<head>

    <script type="text/javascript" src="js/jQuery.js"></script>
    <script type="text/javascript">

        $(function(){
           $('.basicButton').click(function(){
                $("#basic input[type=text]").val(this.id);
                $('#basic').submit();
            });

            $('.functionButton').click(function(){
                $("#function input[type=text]").val(this.id);
                $('#function').submit();
            });

            $('.advancedButton').click(function(){
                $("#advanced input[type=text]").val(this.id);
                $('#advanced').submit();
            });

            $('b').css('font-size','17px');
        });

    </script>

</head>
<body>
<h2>Hello World!</h2>

<div>
    <p><b>basic</b></p>

    <form action="JSP/basic" id="basic">
        <input type="text" name="jspName">
        <input type="submit">
    </form>

    <button type="button" id="main" class="basicButton">main</button>
    <button type="button" id="grammar" class="basicButton">grammar</button>
    <button type="button" id="command" class="basicButton">command</button>
    <button type="button" id="action" class="basicButton">action</button>
    <button type="button" id="object" class="basicButton">object</button>
    <button type="button" id="http" class="basicButton">http</button>
    <button type="button" id="cookie" class="basicButton">cookie</button>
    <button type="button" id="session" class="basicButton">session</button>

</div>


<div>
    <p><b>functions</b></p>

    <form action="JSP/functions" id = "function">
        <input type="text" name="jspName">
        <input type="submit">
    </form>
    <button type="button" id="form" class="functionButton">form</button>
    <button type="button" id="statistic" class="functionButton">statistic</button>
    <button type="button" id="autofresh" class="functionButton">autofresh</button>
    <button type="button" id="redirect" class="functionButton">redirect</button>
    <button type="button" id="mail" class="functionButton">mail</button>
</div>


<div>
    <p><b>advanced</b></p>

    <form action="JSP/advanced" id="advanced">
        <input type="text" name="jspName">
        <input type="submit">
    </form>

    <button type="button" id="JSTL" class="advancedButton">JSTL</button>
    <button type="button" id="EL" class="advancedButton">EL</button>
</div>

</body>
</html>
