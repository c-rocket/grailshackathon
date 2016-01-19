dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
			dbCreate = "update"
			pooled = true
			dialect = org.hibernate.dialect.Oracle10gDialect
			driverClassName = 'oracle.jdbc.OracleDriver'
			username = 'devuser' 
			password = 'Welcome1#'
			url = 'jdbc:oracle:thin:@129.152.150.206:1521/PDB1.metcsgse00209.oraclecloud.internal'
			dbCreate = 'validate'
			properties {
				validationQuery="select 1 from dual"
				testWhileIdle=true
				timeBetweenEvictionRunsMillis=60000
			}
        }
    }
    test {
        dataSource {
			dbCreate = "update"
			pooled = true
			dialect = org.hibernate.dialect.Oracle10gDialect
			driverClassName = 'oracle.jdbc.OracleDriver'
			username = 'devuser' 
			password = 'Welcome1#'
			url = 'jdbc:oracle:thin:@129.152.150.206:1521/PDB1.metcsgse00209.oraclecloud.internal'
			dbCreate = 'validate'
			properties {
				validationQuery="select 1 from dual"
				testWhileIdle=true
				timeBetweenEvictionRunsMillis=60000
			}
        }
    }
    production {
        dataSource {
            dbCreate = "update"
			jndiName = "jdbc/hackathonDB"
        }
    }
}
