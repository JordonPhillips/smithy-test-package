$version: "2"

namespace example.weather.cli

use example.weather#City

@paginated(inputToken: "nextToken", outputToken: "nextToken", pageSize: "pageSize")
service WeatherGradle {
    version: "2006-03-01"
    resources: [
        City
    ]
}
