package com.oracle.grailshackathon

import grails.test.spock.IntegrationSpec
import grails.transaction.Rollback;

@Rollback
class ItemIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

   void "test that items are returned"() {
		when:
		List items = Item.findAll()
		
		then:
		items.size() > 0
    }
}
