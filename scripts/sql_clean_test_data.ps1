param(
    [string] $serverName,
    [string] $databaseName,
    [string] $databaseUserName,
    [string] $databasePassword
)
Install-module -Name SqlServer -Scope CurrentUser -Force
$sql = @"
DELETE FROM list_price_v1 WHERE price_book_indicator = 'E2E';
DELETE FROM cpc_v1 WHERE price_book_indicator = 'E2E';
DELETE FROM clp_v1 WHERE price_book_indicator = 'E2E';
DELETE FROM negotiated_price_v1 WHERE price_book_indicator = 'E2E';
DELETE FROM quote_v1 where price_book_indicator = 'E2E';
DELETE FROM spa_price_v1 where price_book_indicator = 'E2E';
DELETE FROM spa_quote_v1 where price_book_indicator = 'E2E';
"@
$adminDbConnectionString = "Server=tcp:$serverName.database.windows.net,1433;Initial Catalog=$databaseName;Persist Security Info=False;User ID=$databaseUserName;Password=$databasePassword;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;"
Invoke-Sqlcmd $sql -ConnectionString $adminDbConnectionString