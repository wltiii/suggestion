package suggestion.core

import java.util.Collection
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.Agenda;
import org.drools.FactException;
import org.drools.FactHandle;
import org.drools.QueryResults;
import org.drools.RuleBase;
import org.drools.StatefulSession
import org.drools.WorkingMemory;
import org.drools.WorkingMemoryEntryPoint;
import org.drools.concurrent.Future;
import org.drools.event.AgendaEventListener;
import org.drools.event.RuleBaseEventListener;
import org.drools.event.WorkingMemoryEventListener;
import org.drools.runtime.Environment;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.WorkItemManager;
import org.drools.spi.AgendaFilter;
import org.drools.spi.AsyncExceptionHandler;
import org.drools.spi.GlobalResolver;
import org.drools.time.SessionClock;

class StatefulSessionDouble implements StatefulSession {

	def fact
	
	@Override
	public FactHandle insert(Object object) throws FactException {
		this.fact = object
		return null;
	}

	@Override
	public int fireAllRules() throws FactException {
		if (fact.conditions.high > 50 && fact.conditions.high < 90) {
			fact.activity = "play golf"
		}
		else if (20 < fact.conditions.high && fact.conditions.high < 30) {
			fact.activity = "cross country ski"
		}
		return 0;
	}

	@Override
	public void dispose() {
		// do nothing

	}

	@Override
	public Agenda getAgenda() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void setGlobal(String identifier, Object value) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public Object getGlobal(String identifier) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Environment getEnvironment() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void setGlobalResolver(GlobalResolver globalResolver) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public GlobalResolver getGlobalResolver() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public RuleBase getRuleBase() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public int fireAllRules(AgendaFilter agendaFilter) throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public int fireAllRules(int fireLimit) throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public int fireAllRules(AgendaFilter agendaFilter, int fireLimit)
			throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public Object getObject(org.drools.runtime.rule.FactHandle handle) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public FactHandle getFactHandle(Object object) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public FactHandle getFactHandleByIdentity(Object object) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Iterator<?> iterateObjects() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Iterator<?> iterateObjects(ObjectFilter filter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Iterator<?> iterateFactHandles() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Iterator<?> iterateFactHandles(ObjectFilter filter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void setFocus(String focus) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public QueryResults getQueryResults(String query, Object... arguments) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void setAsyncExceptionHandler(AsyncExceptionHandler handler) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void clearAgenda() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void clearAgendaGroup(String group) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void clearActivationGroup(String group) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void clearRuleFlowGroup(String group) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public ProcessInstance startProcess(String processId) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public ProcessInstance startProcess(String processId,
			Map<String, Object> parameters) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Collection<ProcessInstance> getProcessInstances() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public ProcessInstance getProcessInstance(long id) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public WorkItemManager getWorkItemManager() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void halt() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public WorkingMemoryEntryPoint getWorkingMemoryEntryPoint(String id) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public SessionClock getSessionClock() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void addEventListener(WorkingMemoryEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeEventListener(WorkingMemoryEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public List getWorkingMemoryEventListeners() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void addEventListener(AgendaEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void removeEventListener(AgendaEventListener listener) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public List getAgendaEventListeners() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
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
	public FactHandle insert(Object object, boolean dynamic)
			throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void retract(org.drools.runtime.rule.FactHandle handle)
			throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void update(org.drools.runtime.rule.FactHandle handle, Object object)
			throws FactException {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public String getEntryPointId() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Collection<Object> getObjects() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Collection<Object> getObjects(ObjectFilter filter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public <T extends org.drools.runtime.rule.FactHandle> Collection<T> getFactHandles() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public <T extends org.drools.runtime.rule.FactHandle> Collection<T> getFactHandles(
			ObjectFilter filter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public long getFactCount() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return 0;
	}

	@Override
	public Future asyncInsert(Object object) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncRetract(FactHandle factHandle) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncUpdate(FactHandle factHandle, Object object) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncInsert(Object[] array) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncInsert(Collection collect) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncFireAllRules() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public Future asyncFireAllRules(AgendaFilter agendaFilter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public List getRuleBaseUpdateListeners() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		return null;
	}

	@Override
	public void fireUntilHalt() {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

	@Override
	public void fireUntilHalt(AgendaFilter agendaFilter) {
		throw new UnsupportedOperationException("Method not implemented in test double")
		
	}

}
