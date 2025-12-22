RR_PROPRIETARY_RECIPE = "1"

python () {
    import types
    from bb.fetch2 import git
    from bb.fetch2 import methods

    def skip_recipe(fetch_error=False):
        if not d.getVar("RR_PROPRIETARY_RECIPE"):
            return
        if not d.getVar("RR_CUSTOMER_GITLAB_ORDER_DIR"):
            bb.warn("RR_CUSTOMER_GITLAB_ORDER_DIR is not set; skipping this proprietary recipe.")
            raise bb.parse.SkipRecipe("This recipe requires RR_CUSTOMER_GITLAB_ORDER_DIR to be defined. "
                    "The variable should be set to the RidgeRun customer GitLab order directory name. "
                    "For purchase details, see <RR purchases link>.")
        if fetch_error:
            bb.warn("Failed to access RidgeRun proprietary repository; skipping this proprietary recipe.")
            raise bb.parse.SkipRecipe("This recipe requires access to a RidgeRun proprietary repository for the "
                    "configured RR_CUSTOMER_GITLAB_ORDER_DIR. Verify your purchase includes this plugin or "
                    "contact RidgeRun. For purchase details, see <RR purchases link>.")

    skip_recipe()

    def _lsremote(self, ud, d, search):
        import shlex
        from bb.fetch2 import check_network_access
        from bb.fetch2 import FetchError
        from bb.fetch2 import runfetchcmd

        def _lsremote_base(self, ud, d, search):
            repo_url = self._get_repo_url(ud)
            cmd = f'{ud.basecmd} ls-remote {shlex.quote(repo_url)} {search}'

            if 'file://' not in repo_url:
                check_network_access(d, cmd, repo_url)

            output = runfetchcmd(cmd, d, quiet=True)
            return output, cmd

        if d.getVar('_BB_GIT_IN_LSREMOTE', False):
            return ''
        d.setVar('_BB_GIT_IN_LSREMOTE', '1')
        try:
            output = ""
            cmd = ""
            try:
                output, cmd = _lsremote_base(self, ud, d, search)
            except FetchError:
                skip_recipe(fetch_error=True)

            if "" == output:
                raise FetchError(
                    f'The command {cmd} {ud.url} gave empty output unexpectedly'
                )
            return output
        finally:
            d.delVar('_BB_GIT_IN_LSREMOTE')

    for fetcher in methods:
        if isinstance(fetcher, git.Git):
            fetcher._lsremote = types.MethodType(_lsremote, fetcher)
}
