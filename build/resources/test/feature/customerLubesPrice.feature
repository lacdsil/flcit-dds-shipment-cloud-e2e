@customerLubesPrice
      Feature:Publish Customer Lubes Price Topic with List Price
      Scenario: Happy Path for CLP creation with one CPC and one List Price created
        Given PROS published list price from json "pros_list_price_created_input.json" to pds-list-price-condition topic
        And PROS published customer product catalog from json "customer_product_catalog_input.json" to customer-product-catalog topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_list_price_created_output.json" for "CREATED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_list_price_created_api.json"

      Scenario:Publish Customer Lubes Price Topic with List Price and Negotiate Price created
        Given PROS published list price from json "pros_negotiate_price_created_input.json" to pds-list-price-condition topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_list_price_and_nego_price_created_output.json" for "CHANGED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_list_price_and_nego_price_created_api.json"

      Scenario: Publish Customer Lubes Price Topic with List Price deleted
        Given PROS published list price from json "pros_list_price_deleted_input.json" to pds-list-price-condition topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_list_price_deleted_output.json" for "CHANGED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_list_price_deleted_api.json"


        Scenario: Publish Customer Lubes Price Topic with List Price and Negotiated Price deleted
        Given PROS published list price from json "pros_negotiate_price_deleted_input.json" to pds-list-price-condition topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_nego_price_deleted_output.json" for "CHANGED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_nego_price_deleted_api.json"


        Scenario: Publish Customer Lubes Price Topic with List Price changed
        Given PROS published list price from json "pros_list_price_changed_input.json" to pds-list-price-condition topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_list_price_changed_output.json" for "CHANGED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_list_price_changed_api.json"


      Scenario: Publish Customer Lubes Price Topic with Negotiate Price changed
        Given PROS published list price from json "pros_negotiate_price_changed_input.json" to pds-list-price-condition topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_nego_price_changed_output.json" for "CHANGED" event in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_nego_price_changed_api.json"

      Scenario: Publish Customer Lubes Price Topic with Customer product catalog deleted
        Given PROS published customer product catalog from json "customer_product_catalog_delete_input.json" to customer-product-catalog topic
        When CLP should be mapped with mapping condition correctly and saved in clp table successfully 15 seconds later
        Then pds should publish the payload as "customer_lubes_pricing_with_cpc_deleted_output.json" in pds-customer-lubes-price topic
        And call customer lubes api will return "customer_lubes_pricing_with_cpc_deleted_api.json"

