package suggestion.core

import java.io.IOException
import java.lang.ClassNotFoundException
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.util.Set;

import org.drools.RuleBase;
import org.drools.SessionConfiguration;
import org.drools.StatefulSession;
import org.drools.StatelessSession;
import org.drools.definition.type.FactType;
import org.drools.event.RuleBaseEventListener;
import org.drools.rule.Package;
import org.drools.runtime.Environment;

class RuleBaseDouble implements RuleBase {

	@Override
	public StatefulSession newStatefulSession() {
		new StatefulSessionDouble()
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
		throw new UnsupportedOperationException("Method not implemented in test double")
	}

	@Override
	public void addEventListener(RuleBaseEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeEventListener(RuleBaseEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public List<RuleBaseEventListener> getRuleBaseEventListeners() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatelessSession newStatelessSession() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatefulSession newStatefulSession(boolean keepReference) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatefulSession newStatefulSession(InputStream stream) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatefulSession newStatefulSession(InputStream stream,
			boolean keepReference) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatefulSession newStatefulSession(InputStream stream,
			boolean keepReference, SessionConfiguration conf) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public StatefulSession newStatefulSession(SessionConfiguration config,
			Environment environment) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Package[] getPackages() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Package getPackage(String name) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void addPackages(Package[] pkgs) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void addPackage(Package pkg) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void lock() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void unlock() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public int getAdditionsSinceLock() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public int getRemovalsSinceLock() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public void removePackage(String packageName) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeRule(String packageName, String ruleName) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeQuery(String packageName, String queryName) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeFunction(String packageName, String functionName) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeProcess(String id) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public StatefulSession[] getStatefulSessions() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public FactType getFactType(String string) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Set<String> getEntryPointIds() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

}
